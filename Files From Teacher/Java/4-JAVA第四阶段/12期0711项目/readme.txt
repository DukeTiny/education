��ǰ��ʱ����

���������о���ֱ�����á�

Js����̨���ݵģ�
Jquery
LigerUI:
EasyUI:��Ŀ�ĺ�̨����
Vue:��Ŀ��ǰ̨����

============================
ǰ��˷��룺

��˴�JSON.����JSON.�����κ���ʽ��ҳ����ת��

ǰ�˲����κ��ύ��ֻ��Ajax������

============================
����
1��
response.addHeader("Access-Control-Allow-Origin", "*");

2���������Ϳͻ��˹���jsonp����


		$.ajaxSetup({
			  global: true,
			  type: "POST",
			  cache: false,
			  async: false
		});

		
		$.ajax({
			  url: "findAll",
			  success: function(html){
			    console.log("zsf");
			  }
		});

============================
$��ռ����ô�죿
	jQuery.noConflict();�����������������$�Ŀ���Ȩ�öɸ���һ��ʵ�������Ǹ��⡣

	jQuery.ajax({
			  url: "findAll",
			  success: function(html){
			    console.log("zsf");
			  }
		});
============================	
