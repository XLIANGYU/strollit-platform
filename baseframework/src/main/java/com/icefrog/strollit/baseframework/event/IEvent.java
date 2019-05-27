/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.event;

/***
 * SpringRunner interface, 系统初始化资源父接口
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public interface IEvent {
    
    /***
     * Event's initialize
     * @return Object resource
     */
    Object init();
    
    /***
     * Event's destroy
     */
    void destroy();

}
