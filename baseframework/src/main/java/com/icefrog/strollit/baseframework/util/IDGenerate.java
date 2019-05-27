/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.util;

import java.util.UUID;

public class IDGenerate {
	
	public static final String buildID() {
		synchronized (IDGenerate.class) {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}
	}
}