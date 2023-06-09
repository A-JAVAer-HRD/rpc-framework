---
title: Rpc框架
date: 2023-4-26 22:12:57
categories: 
- 项目
tags:
- Spring
- Zookeeper
- Netty

---

详细关注个人博客www.huangrd.top

# Rpc框架

## 一、RPC 概述

### 概述

**RPC**(Remote Procedure Call) 即远程过程调用，RPC 关注的是远程调用而非本地调用。RPC是一种跨服务器通过网络来远程请求调用的方式。RPC框架的实现需要考虑：序列化、传输方式、注册发现等。

PRC框架架构：

![image-20230426202604810](../images/Rpc项目/image-20230426202604810.png)

### 原理

RPC得核心由以下部分组成：

1. 客户端(服务的使用者)：调用远程方法的一端；
2. 客户端桩(Client Stub)：代理类。把客户端调用的方法、方法参数等信息传递给客户端；
3. 网络传输：通过传输客户端方面的请求信息，等到服务端响应完结果后，再把结果通过网络传输回客户端；
4. 服务端桩(Server Stub)：接受客户端执行方法请求信息，去调用服务端得指定方法收集结果，返回结果给客户端；
5. 服务端(服务的提供者)：负责提供服务；

---

以RPC的架构为例，调用关系如下：

1. 服务容器负责启动，加载，运行服务提供者；
2. 服务提供者在启动时，向注册中心提供自己的服务；
3. 服务消费者在启动时，向注册中心订阅自己所需要的服务；
4. 注册中心返回服务的提供者地址列表给服务者，如果有变更，注册中心基于长连接通知消费者；
5. 服务消费者，从提供者的地址列表中，基于自定义的负载均衡算法，选取一台提供者进行调用，如果调用失败，选取另一台提供者；
6. 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计到数据监测中心(心跳检测)。

### 网络传输部分

RPC远程调用方法，要发送网络请求来传递目标类和方法的信息以及所需要的参数给服务的提供者。因此要选用高性能的网络传输方式。

Socket传输：Socket是Java原生的网络通信方式。但是Socket是阻塞IO，性能较差，功能单一。

Netty传输：Netty是同步非阻塞I/O.Netty是基于NIO的CS架构框架，可以快速简单的开发网络应用程序。可以简化TCP和UDP套接字服务器编程，支持多种协议如FTP，SMTP,HTTP等。
