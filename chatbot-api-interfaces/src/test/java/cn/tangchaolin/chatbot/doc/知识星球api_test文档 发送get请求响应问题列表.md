**��δ�����һ��ʹ�� Apache HttpClient ���� HTTP GET �����ʾ�������ڲ�ѯδ�ش�������б������ҽ��Դ���������н��͡�**

1. ���� CloseableHttpClient ����

CloseableHttpClient httpClient = HttpClientBuilder.create().build();
����ʹ�� HttpClientBuilder ������һ�� CloseableHttpClient �������ڷ��� HTTP ����

2. ���� HttpGet ���󣬲����������ַ������ͷ

HttpGet get = new HttpGet("");
get.setHeader("cookie","");
get.setHeader("Content-Type","");
���ﴴ����һ�� HttpGet ���󣬲������������ַ��ͬʱ��������������ͷ���ֱ��� cookie �� Content-Type������ cookie �����������֤�ģ��� Content-Type ��ָ����������ĸ�ʽΪ JSON��

3. �������󣬻�ȡ��Ӧ

CloseableHttpResponse response = httpClient.execute(get);
if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
String res = EntityUtils.toString(response.getEntity());
} else {
System.out.println(response.getStatusLine().getStatusCode());
}

**����ʹ�� CloseableHttpClient ����ִ�������󣬲���ȡ����Ӧ�������Ӧ��״̬��Ϊ 200���ͽ���Ӧ���ӡ���������򣬾ͽ���Ӧ���ӡ������**

**�ܵ���˵����δ�����ʾ�����ʹ�� Apache HttpClient ���� HTTP GET ���󣬲���ȡ��Ӧ���ݡ����ǣ����������ַ������ͷ��Ϣ��û���ṩ��������δ����޷�����������**