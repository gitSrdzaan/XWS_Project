package xws.microservice.searchservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xws.microservice.searchservice.dto.PriceListDTO;
import xws.microservice.searchservice.model.Firm;
import xws.microservice.searchservice.model.PriceList;
import xws.microservice.searchservice.model.User;
import xws.microservice.searchservice.repository.OwnerRepository;
import xws.microservice.searchservice.repository.PriceListRepository;

@Service
public class PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;

    @Autowired
    private OwnerRepository ownerRepository;


    public void addNewPriceList(PriceListDTO priceListDTO) throws Exception {

        PriceList priceList = priceListRepository.findById(priceListDTO.getId()).orElse(new PriceList());

        dto2PriceList(priceListDTO,priceList);

        Firm firm = ownerRepository.findOwnerFirm(priceListDTO.getOwner_id());

        if(firm != null){
            priceList.setOwner(firm);
        }
        else{
            User user = ownerRepository.findOwnerUser(priceListDTO.getOwner_id());
            priceList.setOwner(user);
        }

        try {
            priceListRepository.save(priceList);
        }
        catch(Exception e){
            e.printStackTrace();
            throw new Exception("SearchService: Greska pri dodavanju cjenovnika");
        }

    }

    private void dto2PriceList(PriceListDTO priceListDTO, PriceList priceList) {
        //priceList.setId(priceListDTO.getId());
        priceList.setPriceCDW(priceListDTO.getPriceCDW());
        priceList.setPricePerDay(priceListDTO.getPricePerDay());
        priceList.setPricePerKilometer(priceListDTO.getPricePerKilometer());

    }
}
