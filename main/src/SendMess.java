import gateway.core.domain.SOFForm;
import gateway.model.form.T901;
import gateway.model.msg.M0001;
import gateway.core.CtgManager;
import gateway.core.SBSRequest;
import gateway.core.SBSResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lichao.W At 2015/4/15 17:15
 * wanglichao@163.com
 */
public class SendMess {
    public String sbsLogin(String tellerId, String tellerPwd) {
        M0001 m0001 = new M0001(tellerId, tellerPwd);
        List<String> paramList = new ArrayList<>();
        paramList.add(m0001.getTLRNUM());
        paramList.add(m0001.getTLRPWD());
        paramList.add(m0001.getDEVBLN());
        CtgManager ctgManager = new CtgManager();
        SBSRequest sbsRequest = new SBSRequest(tellerId, tellerId, "0001", paramList);
        SBSResponse sbsResponse = new SBSResponse();
        ctgManager.processSingleResponsePkg(sbsRequest, sbsResponse);
        List<SOFForm> forms = sbsResponse.getSofForms();
        String formCode = forms.get(0).getFormHeader().getFormCode();
        if ("T901".equals(formCode)) {
            T901 t901 = (T901) forms.get(0).getFormBody();
            System.out.println("success!"+t901);
        }
        return forms.get(0).getFormHeader().getFormCode();
    }

    @Test
    public void Test() {
        sbsLogin("0005","00000000");
    }
}
