package gateway.model.msg;

/**
 * Created by Lichao.W At 2015/4/15 17:16
 * wanglichao@163.com
 */
public class M0001 {
    private String TLRNUM;              // 柜员
    private String TLRPWD;              // 密码
    private String DEVBLN = "        "; // 前端设备队列表代码 8个空格

    public M0001(String TLRNUM, String TLRPWD) {
        this.TLRNUM = TLRNUM;
        this.TLRPWD = TLRPWD;
    }

    public String getTLRNUM() {
        return TLRNUM;
    }

    public String getTLRPWD() {
        return TLRPWD;
    }

    public String getDEVBLN() {
        return DEVBLN;
    }
}
