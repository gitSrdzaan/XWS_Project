package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.team.rentacar.model.Codebook;
import xml.team.rentacar.repository.CodeBookRepository;

@Service
public class CodebookService {
	@Autowired
	private CodeBookRepository codeBookRepository;
	
	public Codebook getOne(Long id) {
        return codeBookRepository.getOne(id);
    }
	
	public Codebook update(Long id, String s1, String s2, String s3, String s4) {
    	
		Codebook codebook = codeBookRepository.findById(id).orElse(null);
		List<String> model=new ArrayList<String>();
		List<String> clas=new ArrayList<String>();
		List<String> type=new ArrayList<String>();
		List<String> transmission=new ArrayList<String>();
		if(s1 != null) {
			model = codebook.getCar_model();
			model.add(s1);
			codebook.setCar_model(model);
		}
		if(s2 != null) {
			type = codebook.getFuel_type();
			type.add(s2);
			codebook.setFuel_type(type);
		}
		
		if(s3 != null) {
			clas = codebook.getCar_class();
			clas.add(s3);
			codebook.setCar_class(clas);
		}
		if(s4 != null) {
			transmission = codebook.getCar_transmission();
			transmission.add(s4);
			codebook.setCar_transmission(transmission);
		}
		
		
		
        
        return codebook;
    }
	
	 public void delete(Long id, String s1, String s2, String s3, String s4) {
	        
		 
		 Codebook codebook = codeBookRepository.findById(id).orElse(null);
			List<String> model = new ArrayList<String>();
			List<String> clas=new ArrayList<String>();
			List<String> type=new ArrayList<String>();
			List<String> transmission=new ArrayList<String>();
			
			if(s1 != null) {
				model = codebook.getCar_model();
				model.remove(s1);
				codebook.setCar_model(model);
			}
			if(s2 != null) {
				type = codebook.getFuel_type();
				type.remove(s2);
				codebook.setFuel_type(type);
			}
			
			if(s3 != null) {
				clas = codebook.getCar_class();
				clas.remove(s3);
				codebook.setCar_class(clas);
			}
			if(s4 != null) {
				transmission = codebook.getCar_transmission();
				transmission.remove(s4);
				codebook.setCar_transmission(transmission);
			}
			
	    }
	 
	 public Codebook create(CodebookDTO CodebookDTO) {
		 	Codebook cb= new Codebook();
		 	cb.setId(CodebookDTO.getId());
			cb.setCar_model(CodebookDTO.getCar_model());
			cb.setFuel_type(CodebookDTO.getFuel_type());
			cb.setCar_class(CodebookDTO.getCar_class());
			cb.setCar_transmission(CodebookDTO.getCar_transmission());
			
	        
	        return cb;
	    }
	
}
