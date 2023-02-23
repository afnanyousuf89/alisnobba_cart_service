package com.afnan.cartservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.*;

import org.checkerframework.checker.nullness.Opt;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartserviceApplicationTests {

	@Mock
	private IorderRepo orderRepo;

	@InjectMocks
	private OrderServiceWork orderservicework;

	@Test
	void contextLoads() {
	}

	@Test
	void testforID() {
		order O = new order();
		Long myId = 1L;
		O.setId(myId);
		assertEquals(myId, O.getId());
	}

	@Test
	void testforOrderID() {
		order O = new order();
		Long myId = 1L;
		O.setId(myId);
		assertEquals(myId, O.getId());
	}

	@Test
	void testforProductID() {
		order O = new order();
		Long pid = 1L;
		O.setPid(pid);
		assertEquals(pid, O.getPid());
	}

	@Test
	void testforAllArgsConstructororder() {
		Long Id = 1L;
		Long orderId = 1L;
		Long productId = 1L;
		Long productQty = 10L;
		Long productToalPrice = 1000L;

		order O = new order(Id, productId, productQty, productToalPrice, orderId);
		assertEquals(Id, O.getId());
		assertEquals(orderId, O.getOid());
		assertEquals(productId, O.getPid());
		assertEquals(productQty, O.getPqty());
		assertEquals(productToalPrice, O.getPtotoalprice());
	}

	@Test
	void testforBuildOrder() {
		Long Id = 1L;
		Long orderId = 1L;
		Long productId = 1L;
		Long productQty = 10L;
		Long productToalPrice = 1000L;
		order O = order.builder()
				.id(Id)
				.oid(orderId)
				.pid(productId)
				.pqty(productQty)
				.ptotoalprice(productToalPrice)
				.build();
		assertEquals(Id, O.getId());
		assertEquals(orderId, O.getOid());
		assertEquals(orderId, O.getPid());
		assertEquals(productQty, O.getPqty());
		assertEquals(productToalPrice, O.getPtotoalprice());
	}

	@Test
	void testforSaveNewOrder() {
		Long Id = 1L;
		Long orderId = 1L;
		Long productId = 1L;
		Long productQty = 10L;
		Long productToalPrice = 1000L;
		order O = order.builder()
				.id(Id)
				.oid(orderId)
				.pid(productId)
				.pqty(productQty)
				.ptotoalprice(productToalPrice)
				.build();
		given(orderRepo.save(O)).willReturn(O);
		orderservicework.saveorder(O);
		verify(orderRepo, times(1)).save(O);
	}

	@Test
	void testforViewAllOrder() {
		orderRepo.findAll();
		verify(orderRepo, times(1)).findAll();
	}

	@Test
	void testforGetSingleOrder() {
		Long Id = 1L;
		Long orderId = 1L;
		Long productId = 1L;
		Long productQty = 10L;
		Long productToalPrice = 1000L;
		order O = order.builder()
				.id(Id)
				.oid(orderId)
				.pid(productId)
				.pqty(productQty)
				.ptotoalprice(productToalPrice)
				.build();
		given(orderRepo.findById(Id)).willReturn(Optional.of(O));
		Optional<order> ord = orderservicework.fetchSingleorder(O);
		assertNotNull(ord);
	}

	@Test
	void testforDeleteOrder() {
		Long Id = 1L;
		orderRepo.deleteById(Id);
		verify(orderRepo, times(1)).deleteById(Id);
	}

}
