package com.org.yajuego.constant;

public class Constant {
    public static final String PARENT_ROOT_PATH = Constant.class.getResource("").getPath().replace("target/classes/com/org/yajuego/constant/","");
    public static final String CONFIG_FILE = "src/test/resources/config/config.properties";
    public static final String CONFIG_PROP_PATH = PARENT_ROOT_PATH + CONFIG_FILE;
}
