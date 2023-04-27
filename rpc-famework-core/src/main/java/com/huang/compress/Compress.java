package com.huang.compress;

import com.huang.extension.SPI;

/**
 * @author Huang RD
 * @date 2023/4/25 11:59
 * @description
 */
@SPI
public interface Compress {

    byte[] compress(byte[] bytes);


    byte[] decompress(byte[] bytes);
}
