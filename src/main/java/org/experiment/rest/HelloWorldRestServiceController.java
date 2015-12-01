package org.experiment.rest;

import org.experiment.db.repo.CustomerRepository;
import org.experiment.lang.OrderDetails;
import org.experiment.lang.ProfileBean;
import org.experiment.lang.RestResponse;
import org.experiment.prop.RestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/hello/world")
public class HelloWorldRestServiceController {

	@Autowired
	private ProfileBean activeProfile;

	@Autowired
	private RestProperties restProperties;

	@Autowired
	private CustomerRepository customerDB;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/visitor/{name}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse sayHello(@PathVariable("name") String name) {
//		return new RestResponse(restProperties.getMessage(), name);
		System.out.println(restProperties.getMessage());
		return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDB.findOne(1L)), name);
	}

	@RequestMapping(value = "/testsql",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse testSQL() {

//		jdbcTemplate.execute("SELECT * FROM orderdetails on inner join Products p on od.Productid=p.ProductID where od.quantity > 100");
        /*mysql does not allow deleting records from a table that is part of the select clause - a rewrite is needed >
        inner join orderdetails is transformed into a where clause)*/
        String sqlString = "Delete from %s\n" +
				" where EXISTS\n" +
				"(SELECT *\n" +
				"FROM\n" +
				"%s p\n" +
				"inner join %s s\n" +
				"on (p.supplierID = s.supplierID)\n" +
				"where\n" +
				"%s.quantity > 60\n" +
				"AND\n" +
				"%s.Productid=p.ProductID\n" +
				")";
        String TABLE_NAME_ORDER_DETAILS = "orderdetails";
        String  TABLE_NAME_PRODUCTS = "products";
        String  TABLE_NAME_SUPPLIERS = "suppliers";
        String sql = String.format(sqlString,
				TABLE_NAME_ORDER_DETAILS,
				TABLE_NAME_PRODUCTS,
				TABLE_NAME_SUPPLIERS,
				TABLE_NAME_ORDER_DETAILS,
				TABLE_NAME_ORDER_DETAILS
		) ;

//		OrderDetails orderDetail = jdbcTemplate.queryForObject (sql, new OrderDetailsEntityRowMapper());

//		return new RestResponse(String.format("The class %s was retrieved from DB and returned the following result: %s !", "OrderDetails",orderDetail.getOrderID() ), sql);


		System.out.println(sql);
		jdbcTemplate.execute(sql);
		return new RestResponse("SQL performed!", sql);


	}

	private static final class OrderDetailsEntityRowMapper implements RowMapper<OrderDetails> {

		@Override
		public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			OrderDetails orderDetail = new OrderDetails();

			orderDetail.setOrderID(rs.getInt("orderID"));
			orderDetail.setProductID(rs.getInt("productID"));
			orderDetail.setUnitPrice(rs.getInt("unitPrice"));
			orderDetail.setQuantity(rs.getInt("quantity"));
			orderDetail.setDiscount(rs.getInt("discount"));

			return orderDetail;
		}
	}

}
