package xws.microservis.advertservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xws.microservis.advertservice.dto.BundleDTO;
import xws.microservis.advertservice.dto.RentRequestDTO;
import xws.microservis.advertservice.model.RentRequest;
import xws.microservis.advertservice.model.RentRequestBundle;
import xws.microservis.advertservice.repository.RentRequestBundleRepository;
import xws.microservis.advertservice.repository.RentRequestRepository;

import java.util.ArrayList;


@Service
public class RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Autowired
    private RentRequestBundleRepository bundleRepository;

    @Autowired
    private AdvertService advertService;


    public ArrayList<RentRequest> findUserAll(Long id) {
        return rentRequestRepository.findAllByUser(id);



    }

    public ArrayList<RentRequestBundle> findUserAllBundle(Long id) {

        ArrayList<RentRequestBundle> rentRequestBundles = (ArrayList<RentRequestBundle>) bundleRepository.findAll();

        ArrayList<RentRequestBundle> returnList = new ArrayList<>();

        for(RentRequestBundle bundleIter : rentRequestBundles){
            RentRequest request = bundleIter.getRentRequest().get(0);
            if(request.getRentAdvert().getUser().getId() == id){
                returnList.add(bundleIter);

            }
        }

        return returnList;

    }

    public void save(RentRequestDTO rentRequestDTO) throws Exception {

        RentRequest request = rentRequestRepository.findById(rentRequestDTO.getId()).orElse(null);

        try{
            request.setStatus(rentRequestDTO.getStatus());
            rentRequestRepository.save(request);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Greska pri cuvanju zahtjeva");
        }



    }

    public void modifyBundle(BundleDTO bundleDTO) throws Exception {

        RentRequestBundle bundle = bundleRepository.findById(bundleDTO.getId()).orElse(null);

        try {
            for(int i=0; i < bundle.getRentRequest().size(); i++){
                bundle.getRentRequest().get(i).setStatus(bundleDTO.getRentRequestDTOS().get(i).getStatus());
            }
            bundleRepository.save(bundle);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Greska pri cuvanju bundle zahtjeva");
        }


    }
}
