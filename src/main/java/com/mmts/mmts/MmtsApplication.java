package com.mmts.mmts;

import com.mmts.algorithm.DistanceCalculated;
import com.mmts.algorithm.FairCalculated;
import com.mmts.algorithm.RouteCalculated;
import com.mmts.dao.BooKTicketDao;
import com.mmts.dao.FclassDao;
import com.mmts.dao.RoutesDao;
import com.mmts.dao.StationDao;
import com.mmts.modal.BookTicket;
import com.mmts.modal.Fclass;
import com.mmts.modal.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.mmts")
public class MmtsApplication implements CommandLineRunner {

	@Autowired
	StationDao stationDao;
	@Autowired
	FclassDao fclassDao;
	@Autowired
	BooKTicketDao booKTicketDao;
	@Autowired
	RoutesDao routesDao;
	@Autowired
	RouteCalculated routeCalculated;
	@Autowired
	DistanceCalculated distanceCalculated;
	@Autowired
	FairCalculated fairCalculated;

	public static void main(String[] args)
	{
		SpringApplication.run(MmtsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("helloworld");
		//System.out.println(stationDao.findAll());
		List<Station> list = stationDao.findAll();
		//list.stream().map(x->x.getName()).forEach(System.out::println);
		Station st = stationDao.findByCode("hyb");
		//System.out.println(st.getName());

		Fclass fclass = new Fclass();
		fclass.setFair(50);
		fclass.setName("adv");
		//fclassDao.insert(fclass);
		//fclassDao.findAll().stream().map(x->x.getName()).forEach(System.out::println);
		//System.out.println(fclassDao.findByCname("first").getFair());

		BookTicket bookTicket = new BookTicket();
		bookTicket.setPnr("1234567");
		bookTicket.setS_code("lpi");
		bookTicket.setD_code("fm");
		bookTicket.setFair(33);
		bookTicket.setDtime(LocalDateTime.now());
		bookTicket.setNoadult(1);
		bookTicket.setNochild(1);
		bookTicket.setCname("first");

		//booKTicketDao.insert(bookTicket);

		//routesDao.findRoutesByCode("lpi").stream().map(x->x.getRoute_no()).forEach(System.out::println);
		//System.out.println(routesDao.findByCodeAndRouteno("hyb", 3).getDistance());

		//System.out.println(routeCalculated.calculateCommonRoute("fm", "nlrd"));

		//System.out.println(distanceCalculated.calculateDistance("lpi", "lpl"));
		//System.out.println(fairCalculated.calculateFair("lpi", "lpl", 2,"vendor"));

	}
}
