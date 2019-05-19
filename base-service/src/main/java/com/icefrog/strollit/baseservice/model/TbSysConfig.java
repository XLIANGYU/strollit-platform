package com.icefrog.strollit.baseservice.model;

import lombok.Data;

@Data
public class TbSysConfig {
    private String id;

    private String configKey;

    private String configValue;

    private String configRemark;
    
}