package xws.microservis.rentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xws.microservis.rentservice.dto.PriceListDTO;
import xws.microservis.rentservice.model.Firm;
import xws.microservis.rentservice.model.PriceList;
import xws.microservis.rentservice.model.User;
import xws.microservis.rentservice.repository.FirmRepository;
import xws.microservis.rentservice.repository.PriceListRepository;
import xws.microservis.rentservice.repository.UserRepository;

@Service
public class PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;

    @Autowired
    private FirmRepository firmRepository;

    @Autowired
    private UserRepository userRepository;

    public void addNewRentAdvert(PriceListDTO priceListDTO) throws Exception {

        PriceList priceList = priceListRepository.findById(priceListDTO.getId()).orElse(new PriceList());

        dto2PriceList(priceListDTO,priceList);

        Firm firm = firmRepository.findById(priceListDTO.getOwner_id()).orElse(null);

        if(firm != null){
            priceList.setFirm(firm);
        }
        else{
            User user = userRepository.findById(priceListDTO.getOwner_id()).orElse(null);
            priceList.setUser(user);
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
        priceList.setId(priceListDTO.getId());
        priceList.setPriceCDW(priceListDTO.getPriceCDW());
        priceList.setPricePerDay(priceListDTO.getPricePerDay());
        priceList.setPricePerKilometer(priceListDTO.getPricePerKilometer());

    }
}
