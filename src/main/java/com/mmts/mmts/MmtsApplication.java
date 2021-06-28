package com.mmts.mmts;

import com.mmts.dao.FclassDao;
import com.mmts.dao.StationDao;
import com.mmts.modal.Fclass;
import com.mmts.modal.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.mmts")
public class MmtsApplication implements CommandLineRunner {

	@Autowired
	StationDao stationDao;
	@Autowired
	FclassDao fclassDao;
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
		System.out.println(st.getName());

		Fclass fclass = new Fclass();
		fclass.setFair(50);
		fclass.setName("adv");
		//fclassDao.insert(fclass);
		//fclassDao.findAll().stream().map(x->x.getName()).forEach(System.out::println);

	}
}
