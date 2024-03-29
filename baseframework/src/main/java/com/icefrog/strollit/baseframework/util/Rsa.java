/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/**
 * RAS签名验签类
 */
public class Rsa {

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * RSA签名
     *
     * @param content 待签名数据
     * @param privateKey 私钥
     * @param inputCharset 编码格式
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String inputCharset)
        throws NoSuchAlgorithmException,
        InvalidKeySpecException,
        InvalidKeyException,
        UnsupportedEncodingException,
        SignatureException {
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Util.decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey priKey = keyFactory.generatePrivate(priPKCS8);

        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

        signature.initSign(priKey);
        signature.update(content.getBytes(inputCharset));

        byte[] signed = signature.sign();

        return Base64Util.encode(signed);
    }

    /**
     * RSA验签名检查
     *
     * @param content 待签名数据
     * @param sign 签名值
     * @param publicKey 公钥
     * @param inputCharset 编码格式
     * @return 布尔值
     */
    public static boolean verify(String content, String sign, String publicKey,
        String inputCharset) throws NoSuchAlgorithmException,
        InvalidKeySpecException, InvalidKeyException,
        UnsupportedEncodingException,
        SignatureException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] encodedKey = Base64Util.decode(publicKey);
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

        signature.initVerify(pubKey);
        signature.update(content.getBytes(inputCharset));

        boolean bverify = signature.verify(Base64Util.decode(sign));
        return bverify;
    }

    /**
     * 解密
     *
     * @param content 密文
     * @param privateKey 私钥
     * @param inputCharset 编码格式
     * @return 解密后的字符串
     */
    public static String decrypt(String content, String privateKey, String inputCharset)
        throws Exception {
        PrivateKey prikey = getPrivateKey(privateKey);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, prikey);

        InputStream ins = new ByteArrayInputStream(Base64Util.decode(content));
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        // rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
        byte[] buf = new byte[128];
        int bufl;

        while ((bufl = ins.read(buf)) != -1) {
            byte[] block = null;

            if (buf.length == bufl) {
                block = buf;
            } else {
                block = new byte[bufl];
                for (int i = 0; i < bufl; i++) {
                    block[i] = buf[i];
                }
            }

            writer.write(cipher.doFinal(block));
        }

        return new String(writer.toByteArray(), inputCharset);
    }

    /**
     * 得到私钥
     *
     * @param key 密钥字符串（经过base64编码）
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {

        byte[] keyBytes;

        keyBytes = Base64Util.decode(key);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        return privateKey;
    }
}
