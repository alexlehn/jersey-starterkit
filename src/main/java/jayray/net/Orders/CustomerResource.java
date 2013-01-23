package jayray.net.Orders;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yammer.metrics.annotation.Timed;

@Path("customer")
public class CustomerResource {

	@GET
	@Path("id/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Timed(name = "getCustomer")
	public Customer getCustomer(@PathParam("id") String id) {
		return customerDAL(id);
	}

	// handle request
	private Customer customerDAL(String id) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName("Mighty Pulpo");
		Address address = new Address();
		address.setCity("austin");
		address.setState("TX");
		address.setAddressType("home");
		customer.getAddresses().add(address);
		address = new Address();
		address.setCity("sterling");
		address.setState("VA");
		address.setAddressType("work");
		customer.getAddresses().add(address);
		return customer;
	}
}
