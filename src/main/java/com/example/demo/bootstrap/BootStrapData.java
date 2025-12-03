package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if (partRepository.count() == 0 && outsourcedPartRepository.count() == 0) {            //46-90 parts and outsourced objects, 119-132 products
            // object for Parts (Hardware)
            InhousePart board = new InhousePart();
            board.setName("Shop Board");
            board.setPrice(45);
            board.setInv(25);
            board.setId(1);

            partRepository.save(board);

            //outsourced objects
            InhousePart bearings = new InhousePart();
            bearings.setName("Bearings");
            bearings.setPrice(20);
            bearings.setInv(10);
            bearings.setId(2);

            partRepository.save(bearings);

            OutsourcedPart wheels = new OutsourcedPart();
            wheels.setName("Wheels");
            wheels.setCompanyName("Spitfire");
            wheels.setPrice(10);
            wheels.setInv(32);
            wheels.setId(3);

            partRepository.save(wheels);

            OutsourcedPart gripTape = new OutsourcedPart();
            gripTape.setName("Grip Tape");
            gripTape.setCompanyName("MOB Grip");
            gripTape.setPrice(5);
            gripTape.setInv(50);
            gripTape.setId(4);

            partRepository.save(gripTape);

            OutsourcedPart trucks = new OutsourcedPart();
            trucks.setName("Trucks");
            trucks.setCompanyName("independent");
            trucks.setPrice(35);
            trucks.setInv(20);
            trucks.setId(5);

            partRepository.save(trucks);
        }

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        if (productRepository.count() == 0) {
            Product tShirt = new Product("Shop Tee",15.0,30);
            Product bakerBoard = new Product("Baker Board",75.0,10);
            Product lessons = new Product("Lessons",100.0,5);
            Product stickers = new Product("Stickers",2.00,150);
            Product scooter = new Product("Scooter",60.0,5);

            productRepository.save(tShirt);
            productRepository.save(bakerBoard);
            productRepository.save(lessons);
            productRepository.save(stickers);
            productRepository.save(scooter);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
