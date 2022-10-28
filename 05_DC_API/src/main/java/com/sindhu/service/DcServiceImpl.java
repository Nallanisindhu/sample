package com.sindhu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindhu.bindings.Children;
import com.sindhu.bindings.DcSummary;
import com.sindhu.bindings.Education;
import com.sindhu.bindings.Income;
import com.sindhu.bindings.PlanSelection;
import com.sindhu.entity.DcCaseEntity;
import com.sindhu.entity.DcChildrenEntity;
import com.sindhu.entity.DcEducationEntity;
import com.sindhu.entity.DcIncomeEntity;
import com.sindhu.entity.PlanEntity;
import com.sindhu.repository.DcCaseRepo;
import com.sindhu.repository.DcChildrenRepo;
import com.sindhu.repository.DcEducationRepo;
import com.sindhu.repository.DcIncomeRepo;
import com.sindhu.repository.PlanRepo;

@Service
public class DcServiceImpl implements DcService {
    @Autowired
	private  DcCaseRepo dcCaseRepo;
    @Autowired
    private PlanRepo planRepo;
    @Autowired
    private DcIncomeRepo dcIncomeRepo;
    @Autowired
    private DcEducationRepo dcEducationRepo;
    @Autowired
    private DcChildrenRepo dcChildRepo;
    
	//this method is used to load the case num based on the load cases
	@Override
	public Long loadCaseNumber(Integer appId) {
		DcCaseEntity findByAppId = dcCaseRepo.findByAppId(appId);
		if(findByAppId !=null) {
			return findByAppId.getCaseNum();
		}
		return null;
	}


	@Override
	public List<String> getPlanNames() {
		List<PlanEntity> findAll = planRepo.findAll();
		List<String>plans=new ArrayList<>();
	  for(PlanEntity entity:findAll) {
		  plans.add(entity.getPlanName());
	  }
		
		return plans;
	}

	@Override
	public Long saveplanSelection(PlanSelection planSelection) {
		
		DcCaseEntity  entity=new DcCaseEntity();
		entity.setPlanId(planSelection.getPlanId());
		entity.setAppId(planSelection.getAppId());
		
		 entity = dcCaseRepo.save(entity);
		 if(entity.getCaseNum()!=null) {
			 return entity.getCaseNum();
		 }
		return null;
	}

	@Override
	public Long saveIncomeData(Income income) {
		DcIncomeEntity entity=new DcIncomeEntity();
		BeanUtils.copyProperties(income, entity);
	dcIncomeRepo.save(entity);
	
		
		return income.getCaseNum();
	}

	@Override
	public Long saveEducation(Education educaton) {
		DcEducationEntity entity=new DcEducationEntity();
		BeanUtils.copyProperties(educaton, entity);
		dcEducationRepo.save(entity);
		return educaton.getCaseNum();
	}

	@Override
	public Long savedChildren(List<Children> children) {
		for(Children c:children) {
		DcChildrenEntity entity=new DcChildrenEntity();
		BeanUtils.copyProperties(c, entity);
		dcChildRepo.save(entity);
		}
		return children.get(0).getCaseNum();
	}

	
	@Override
	public DcSummary getSummary(Long caseNumber) {
		String planName="";
		DcIncomeEntity dcIncomeEntity = dcIncomeRepo.findByCaseNum(caseNumber);
		DcEducationEntity dcEducationEntity = dcEducationRepo.findByCaseNum(caseNumber);
		List<DcChildrenEntity> dcChildrenEntity = dcChildRepo.findByCaseNum(caseNumber);
		Optional<DcCaseEntity> dcCase = dcCaseRepo.findById(caseNumber);
		if(dcCase.isPresent()) {
			Integer planId = dcCase.get().getPlanId();
			Optional<PlanEntity> plan = planRepo.findById(planId);
			if(plan.isPresent()) {
			planName=	plan.get().getPlanName();
			}
		
		}
		//set the data to summary object
		DcSummary summary=new DcSummary();
		summary.setPlanName(planName);
		
		Income income=new Income();
		BeanUtils.copyProperties(dcIncomeEntity, income);
		summary.setIncome(income);
		
		Education education=new Education();
		BeanUtils.copyProperties(dcEducationEntity, education);
		summary.setEducation(education);
		
		List<Children> children=new ArrayList();
		for(DcChildrenEntity entity:dcChildrenEntity) {
			Children ch=new Children();
			BeanUtils.copyProperties(entity,ch);
			children.add(ch);
		}
		
		
		return null;
	}

}
