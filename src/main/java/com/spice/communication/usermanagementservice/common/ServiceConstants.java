package com.spice.communication.usermanagementservice.common;

public interface ServiceConstants {

     enum GENDER {

        MALE(1,"Male"),
        FEMALE(2,"Female"),
        OTHER(3,"Other");

        private Integer code;
        private String desc;

        GENDER(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static GENDER search(Integer code) {
            if(code != null) {
                for(GENDER gender : GENDER.values()) {
                    if(gender.getCode().intValue() == code.intValue()) {
                        return gender;
                    }
                }
            }
            return GENDER.OTHER;
        }

        public static GENDER search(String desc){
            if(desc!=null && desc.length()>0){
                GENDER[] genders = GENDER.values();
                for(GENDER gender: genders) {
                    if(gender.getDesc().equals(desc)){
                        return gender;
                    }
                }
            }
            return GENDER.OTHER;
        }
    }
}
