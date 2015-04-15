package gateway.model.form;

import gateway.core.domain.SOFFormBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lichao.W At 2015/4/15 17:32
 * wanglichao@163.com
 */
public class T901 extends SOFFormBody {
    private String ORGIDT;
    private String DEPNUM;
    private String GRPNUM;
    private String TLRNAM;
    private String TLRTYP;
    private String TLRLVL;
    private String AUTMA1;
    private String AUTPW1;
    private String AUTMA2;
    private String AUTPW2;
    private String SYSDAT;
    private String TXNCNT;
    private List<String> beanList = new ArrayList<>();

    {
        fieldTypes = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        fieldLengths = new int[]{3, 2, 2, 8, 1, 1, 4, 8, 4, 8, 8, 4};
    }

    @Override
    public void assembleFields(int offset, byte[] buffer) {
        super.assembleFields(offset, buffer);
        byte[] bytes = new byte[buffer.length - 53];
        System.arraycopy(buffer, 53, bytes, 0, bytes.length);
        int cnt = Integer.parseInt(TXNCNT);
        if (bytes.length / cnt != 4) {
            throw new RuntimeException("长度错误,交易码数:" + cnt + " 报文长：" + bytes.length);
        }
        String txns = new String(bytes);
        for (int i = 0; i < cnt; i++) {
            beanList.add(txns.substring(i, i + 4));
        }
    }

    public String getORGIDT() {
        return ORGIDT;
    }

    public void setORGIDT(String ORGIDT) {
        this.ORGIDT = ORGIDT;
    }

    public String getDEPNUM() {
        return DEPNUM;
    }

    public void setDEPNUM(String DEPNUM) {
        this.DEPNUM = DEPNUM;
    }

    public String getGRPNUM() {
        return GRPNUM;
    }

    public void setGRPNUM(String GRPNUM) {
        this.GRPNUM = GRPNUM;
    }

    public String getTLRNAM() {
        return TLRNAM;
    }

    public void setTLRNAM(String TLRNAM) {
        this.TLRNAM = TLRNAM;
    }

    public String getTLRTYP() {
        return TLRTYP;
    }

    public void setTLRTYP(String TLRTYP) {
        this.TLRTYP = TLRTYP;
    }

    public String getTLRLVL() {
        return TLRLVL;
    }

    public void setTLRLVL(String TLRLVL) {
        this.TLRLVL = TLRLVL;
    }

    public String getAUTMA1() {
        return AUTMA1;
    }

    public void setAUTMA1(String AUTMA1) {
        this.AUTMA1 = AUTMA1;
    }

    public String getAUTPW1() {
        return AUTPW1;
    }

    public void setAUTPW1(String AUTPW1) {
        this.AUTPW1 = AUTPW1;
    }

    public String getAUTMA2() {
        return AUTMA2;
    }

    public void setAUTMA2(String AUTMA2) {
        this.AUTMA2 = AUTMA2;
    }

    public String getAUTPW2() {
        return AUTPW2;
    }

    public void setAUTPW2(String AUTPW2) {
        this.AUTPW2 = AUTPW2;
    }

    public String getSYSDAT() {
        return SYSDAT;
    }

    public void setSYSDAT(String SYSDAT) {
        this.SYSDAT = SYSDAT;
    }

    public String getTXNCNT() {
        return TXNCNT;
    }

    public void setTXNCNT(String TXNCNT) {
        this.TXNCNT = TXNCNT;
    }

    public List<String> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<String> beanList) {
        this.beanList = beanList;
    }
}
