<%@page import="java.util.regex.Pattern" %>

<%@ page language="java" contentType="text/html; charset=EUC_KR"
	pageEncoding="EUC_KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC_KR">
<title>���� �Խ��� �����!!!</title>
</head>
<body>

	<% 
	    request.setCharacterEncoding("euc-kr");
		int idx = 1;
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String regdate = request.getParameter("regdate");
		int count = 10000;
		String content = request.getParameter("content");
		
		if(title == "" ||title == null) out.println("title�� null�Դϴ�.");
		 
		if(writer == "" ||writer == null)
		    out.println("writer�� null�Դϴ�.");   
		else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
		    out.println("�̸��� ������ �ƴմϴ�.");
		 
		if(regdate == "" ||regdate == null)
		    out.println("regdate�� null�Դϴ�.");
		else if(!Pattern.matches("^[0-9]*$", regdate))
		    out.println("���������� �ƴմϴ�.");
		 
		if(content == "" ||content == null) out.println("content�� null�Դϴ�.");
	%>


	<h1>�Խ��� ����Ʈ</h1>
	<table border='1'>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>��¥</th>
			<th>��ȸ��</th>
		</tr>
		
		<tr>
			<td><%=idx%></td>
			<td><%=title%></td>
			<td><%=writer%></td>
			<td><%=regdate%></td>
			<td><%=count%></td>
		</tr>

	</table>
	<a href='write.jsp'>�۾���</a>
</body>
</html>