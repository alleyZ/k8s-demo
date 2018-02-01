package com.alleyz.k8s.svc.user.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.io.Serializable;


    @Entity
    @Table(name="TBL_SYS_USER")
    @Getter @Setter
    public class TblSysUsers implements Serializable {


        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid")
        @Column(name = "USER_ID", unique = true, length = 40)
        private String userId; // 用户ID

        @Column(name = "USER_CODE", nullable = false, length = 40)
        private String userCode; // 用户账号

        @Column(name = "USER_NAME", length = 60)
        private String userName; // 用户姓名

        @Column(name = "AGENT_NAME", length = 60)
        private String agentName; // 坐席姓名 昵称

        @Column(name = "USER_NO", length = 40)
        private String userNo; // 用户内部编号

        @Column(name = "USER_TYPE", length = 8)
        private String userType; // 用户类型(通用编码表中关联USER_TYPE 0系统内置，1开发人员，2客户职员)

        @Column(name = "ORG_ID", length = 40)
        private String orgId; // 机构ID(IS_ORG=1的)

        @Column(name = "DEPT_ID", length = 40)
        private String deptId; // 部门ID(IS_ORG=0的)

        @Column(name = "PASSWORD", length = 32)
        private String password; // 密码

        @Column(name = "PWD_VALID_DAY", length = 11)
        private String pwdValidDay; // 密码到期日

        @Column(name = "BIRTHDAY", length = 11)
        private String birthday; // 生日

        @Column(name = "SEX", length = 8)
        private String sex; // 性别

        @Column(name = "HIRE_DATE", length = 11)
        private String hireDate; // 入职时间

        @Column(name = "CERVIFICATE_TYPE", length = 8)
        private String cervificateType; // 证件类型

        @Column(name = "CERVIFICATE_NO", length = 20)
        private String cervificateNo; // 证件号码

        @Column(name = "EDUCATION", length = 8)
        private String education; // 教育水平

        @Column(name = "MOBILE", length = 20)
        private String mobile; // 手机

        @Column(name = "TELEPHONE", length = 20)
        private String telephone; // 联系电话

        @Column(name = "OFFICEPHONE", length = 20)
        private String officephone; // 单位电话

        @Column(name = "EMAIL", length = 60)
        private String email; // EMAIL

        @Column(name = "ADDRESS", length = 100)
        private String address; // 联系地址

        @Column(name = "POST_CODE", length = 20)
        private String postCode; // 邮政编码

        @Column(name = "CONTACT_NAME", length = 60)
        private String contactName; // 联系人

        @Column(name = "CONTACT_PHONE", length = 20)
        private String contactPhone; // 联系人电话

        @Column(name = "PHOTO", length = 256)
        private String photo; // 照片

        @Column(name = "IS_EDIT", precision = 1, scale = 0)
        private Boolean isEdit; // 可否编辑

        @Column(name = "IS_LOGIN", precision = 1, scale = 0)
        private Boolean isLogin; // 是否免登录

        @Column(name = "IS_SIGN", precision = 1, scale = 0)
        private Boolean isSign; // 是否免签名

        @Column(name = "ENABLED", precision = 1, scale = 0)
        private int enabled = 1; // 状态，1 启用，0停用

        @Column(name = "EXTEND_FIELD1", length = 20)
        private String extendField1; // 扩展字段

        // 创建者主键值
        @Column(name="CREATOR")

        protected String creator;

        // 创建时间
        @Column(name="CREATE_TIME")
        protected String createTime;

        // 最后修改者主键值
        @Column(name="LAST_MODIFIER")
        protected String lastModifier;

        // 最后修改时间
        @Column(name="LAST_MODIFY_TIME")
        protected String lastModifyTime;

        // 备注
        @Column(name="REMARK")
        protected String remark;

        // 租户ID
        @Column(name="DOMAIN_ID")
        protected String domainId;

        public String toString() {
            return "SysUser [userCode=" + userCode + ", userName=" + userName
                    + ", userId=" + userId + ", orgId=" + orgId + ", deptId=" + deptId
                    + ", password=" + password ;
        }

    }

