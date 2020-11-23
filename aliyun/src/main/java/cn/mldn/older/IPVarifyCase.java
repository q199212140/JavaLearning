package cn.mldn.older;

class IPValidator {

    private IPValidator() {
    }

    ;

    public static boolean validateIP(String ip) {
        if ((null == ip) || ("".equals(ip))) {
            return false;
        }

        String regex = "([12]?[0-9]?[0-9]\\.){3}[12]?[0-9]?[0-9]";

        //ip��ַ�����ж���ȷ�󣬲���жϵ��ʮ����ֵ��Χ
        if (ip.matches(regex)) {
            String result[] = ip.split("\\.");
            for (int x = 0; x < result.length; x++) {
                int temp = Integer.parseInt(result[x]);
                if (temp > 255) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}

public class IPVarifyCase {

    public static void main(String[] args) {
        System.out.println("Lesson 63 : IP[��һλ����ֻ�����ޡ�1��2���������ݿ�����0-9,�� ����λ0-9]]��֤��");

        String IPStr = "192.168.2.3";
        System.out.println(IPValidator.validateIP(IPStr));
    }
}
