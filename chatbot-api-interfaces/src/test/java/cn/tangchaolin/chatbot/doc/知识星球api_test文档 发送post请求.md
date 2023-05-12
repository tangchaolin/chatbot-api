
**��δ�����һ��ʹ�� Apache HttpClient ���� HTTP POST �����ʾ���������Ŀ����֪ʶ����֪ʶ������������һ�����⣬����û��ⷢ��һ���ش������Ƕ���δ������ϸ����:**



1. ���� CloseableHttpClient ����
���ȣ����봴����һ�� CloseableHttpClient �������ڷ��� HTTP �������������ͨ�� HttpClientBuilder ��� create() ���������ġ����������ʹ��Ĭ�ϵ����������� CloseableHttpClient ����

java
Copy
CloseableHttpClient httpClient = HttpClientBuilder.create().build();
2. ���� HttpPost ����
�����������봴����һ�� HttpPost ����������Ŀ���ַ���� HTTP POST ���������Ŀ���ַ��֪ʶ�����һ�����⣬����û��ⷢ��һ���ش������ַΪ��
https://api.zsxq.com/v2/topics/412884248251548/answer

HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412884248251548/answer");
3. �������ͷ
�����������������һЩ����ͷ����Щ����ͷ���� cookie �� Content-Type �ȡ����� cookie ���û�����֤��Ϣ��Content-Type ���������ݵ����͡�

post.addHeader("cookie", "__cuid=5330a556392a4c5b8084b4cbc165e0f3; amp_fef1e8=930aec23-e22e-4f11-8864-0389bd5095d1R...1g55hl79m.1g55hl79t.1.1.2; UM_distinctid=183e61195d535b-0bddac94679c75-19525635-1aeaa0-183e61195d7c52; sensorsdata2015jssdkcross={\"distinct_id\":\"241858242255511\",\"first_id\":\"17ebd0b4317ecb-0b27f672c2d3af-133a6253-1296000-17ebd0b4318ba7\",\"props\":{\"$latest_traffic_source_type\":\"ֱ������\",\"$latest_search_keyword\":\"δȡ��ֵ_ֱ�Ӵ�\",\"$latest_referrer\":\"\"},\"$device_id\":\"17ebd0b4317ecb-0b27f672c2d3af-133a6253-1296000-17ebd0b4318ba7\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgwMmQ2YjZiOWIxZjMtMGQ4YzMzZjhmYTA3YmEtMzU3MzZhMDMtMTI5NjAwMC0xODAyZDZiNmI5YzEwODYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyNDE4NTgyNDIyNTU1MTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"241858242255511\"}}; abtest_env=product; zsxqsessionid=8fae9a083a4874ab833c2158a44deb82; zsxq_access_token=5D862869-1229-A9B6-1BC1-C662EC4B16DD_D625BA7FD9CBBDFA");
post.addHeader("Content-Type", "application/json;charset=utf8");
4. 
5. �����������
������������������������Ĳ���������ʹ����һ�� JSON ��ʽ���ַ�����Ϊ��������������ش���ı����ݡ�ͼƬ ID ���Ƿ�������Ϣ��

String paramJson = "{\n" +
"  \"req_data\": {\n" +
"    \"text\": \"�Լ�ȥ�ٶȣ�\\n\",\n" +
"    \"image_ids\": [],\n" +
"    \"silenced\": false\n" +
"  }\n" +
"}";

StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
post.setEntity(stringEntity);
6. 
7. ���� HTTP ���󲢴�����Ӧ
��󣬴���ʹ�� CloseableHttpClient ����� execute() �������� HTTP ���󣬲���ȡ��Ӧ����������Ӧ״̬��Ϊ HttpStatus.SC_OK�����ʾ����ɹ�������ͨ�� EntityUtils.toString() ������ȡ��Ӧ���ݣ����򣬴�ӡ��Ӧ״̬�롣


CloseableHttpResponse response = httpClient.execute(post);
if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
String res = EntityUtils.toString(response.getEntity());
System.out.println(res);
} else {
System.out.println(response.getStatusLine().getStatusCode());
}

**��֮����δ�����һ��ʹ�� Apache HttpClient ���� HTTP POST �����ʾ����������֪ʶ�����һ�����ⷢ��һ���ش����У�CloseableHttpClient ���ڷ��� HTTP ����HttpPost �������� HTTP POST ����StringEntity �������������������HttpResponse ���ڴ�����Ӧ���**