<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.hsbc.model.Product,java.util.List"%>

	<table>
		<%
			List<Product> prod = (List<Product>) request.getAttribute("products");
		for (Product p : prod) {
		%>
		<tr>
			<td><%=p.getProductCode()%></td>
			<td><%=p.getProductName()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getQuantity()%></td>
			<td><%=p.getRol()%></td>

		</tr>
		<%
			}
		%>
	</table>