package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.CurrentUserSession;
import com.masai.dto.MemberUpdateDto;
import com.masai.exception.AdharCardException;
import com.masai.exception.IdCardException;
import com.masai.exception.LoginException;
import com.masai.exception.MemberException;
import com.masai.exception.PanCardException;
import com.masai.exception.VaccineRegistrationException;
import com.masai.model.IdCard;
import com.masai.model.Member;
import com.masai.model.VaccineRegistration;
import com.masai.repository.AdharCardRepo;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.IdCardRepo;
import com.masai.repository.MemberRepo;
import com.masai.repository.PanCardRepo;
import com.masai.repository.VaccineRegistrationRepo;

@Service
public class MemberServicesImpl implements MemberServices{
	@Autowired
	private VaccineRegistrationRepo vaccineRegistrationRepo;
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	@Autowired
	private IdCardRepo idCardRepo;
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private AdharCardRepo adharCardRepo;
	
	@Autowired
	private PanCardRepo panCardRepo;
	
	
	@Override
	public Member getMemberByld(String key, Integer idcardid) throws LoginException, MemberException, IdCardException {
//		CurrentUserSession loggedInUser = currentUserSessionRepo.findByUuid(key);
//		if(loggedInUser!=null) {
//		if(loggedInUser.getAdmin()==false) {
//			Optional<IdCard> idCard = idCardRepo.findById(idcardid);
//			if(idCard.isEmpty()) {
//				throw new IdCardException("No ID card found with this card ID - "+idcardid);
//			}else {
//				Member mm = memberRepo.findByidCard(idcardid);
//				return mm;
//			}
//		}else{
//			throw new LoginException("Person logged in is a admin not member ");
//		}
//		}else {
//			throw new LoginException("To get the details login first ");
//		} 
		return null;
	}

	@Override
	public Member getMemberByAdharNo(String adharno) throws MemberException,AdharCardException {
//		Member mm = memberRepo.findByAdharcardNo(adharno);
//		if (mm == null) {
//			throw new MemberException("No member found with this aadhaar card number ");
//		}else {
//			return mm;
//		} 
		return null;
		
	}

	@Override
	public Member getMemberByPanNo(String panNo) throws MemberException,PanCardException {
//		Member mm = memberRepo.getFindByPanNo(panNo);
//		if (mm == null) {
//			throw new MemberException("No member found with this aadhaar card number ");
//		}else {
//			return mm;
//		} 
		return null;
	}

	@Override
	public Member addMember(String key, Member member) throws LoginException, MemberException,VaccineRegistrationException {
		CurrentUserSession loggedInUser = currentUserSessionRepo.findByUuid(key);
		if(loggedInUser!=null) {
		if(loggedInUser.getAdmin()==false) {
			Optional<Member> mm = memberRepo.findById(member.getMemberId());
			Optional<VaccineRegistration> vaccineRegistration = vaccineRegistrationRepo.findById(loggedInUser.getUserId());
			if(vaccineRegistration.isPresent()) {
				if(mm.isPresent()) {
					throw new MemberException("Member already present ");
				}else {
					VaccineRegistration vr = vaccineRegistration.get();
					 final Member x = member;
					 vr.getMember().add(x);
					 memberRepo.save(x);
					 return x;
				}
			}else {
				throw new VaccineRegistrationException("No vaccine registration found ");
			}
		}else{
			throw new LoginException("Person logged in is a admin");
		}
		}else {
			throw new LoginException("To get the details login first ");
		}
	}
 
	
	 
	
	
	@Override
	public Member updateMember(String key,Integer idcardid, MemberUpdateDto MemberUpdateDto) throws LoginException, MemberException,VaccineRegistrationException,IdCardException  {
//		CurrentUserSession loggedInUser = currentUserSessionRepo.findByUuid(key);
//		if(loggedInUser!=null) {
//			
//		if(loggedInUser.getAdmin()==false) {
//			Member mm = memberRepo.findByidCard(idcardid);
//			mm.getIdcard().setName(MemberUpdateDto.getName());
//			mm.getIdcard().setAddress(MemberUpdateDto.getAddress());
//			mm.getIdcard().setCity(MemberUpdateDto.getCity());
//			mm.getIdcard().setDateOfBirth(MemberUpdateDto.getDateOfBirth());;
//			mm.getIdcard().setGender(MemberUpdateDto.getGender());
//			mm.getIdcard().setState(MemberUpdateDto.getState());
//			
//			memberRepo.save(mm);
//			return mm;
//			
//			}else{
//			throw new LoginException("Person logged in is a admin");
//		}
//		
//		
//		}else {
//			throw new LoginException("To update the details login first ");
//		}
		return null;
	}

	@Override
	public Member deleteMember(String key,Integer idcardid) throws LoginException, MemberException,IdCardException,VaccineRegistrationException {
//		CurrentUserSession loggedInUser = currentUserSessionRepo.findByUuid(key);
//		if(loggedInUser!=null) {
//			
//		if(loggedInUser.getAdmin()==false) {
//			Optional<VaccineRegistration> vaccineRegistration = vaccineRegistrationRepo.findById(loggedInUser.getUserId());
//			if(vaccineRegistration.isPresent()) {
//				Member mm = memberRepo.findByidCard(idcardid);
//				VaccineRegistration vr = vaccineRegistration.get();
//				vr.getMember().remove(mm);
//				memberRepo.delete(mm);
//				return mm;
//			}else {
//				throw new VaccineRegistrationException("No vaccine registration found ");
//			}
//			}else{
//			throw new LoginException("Person logged in is a admin");
//		}
//		}else {
//			throw new LoginException("To update the details login first ");
//		}
//} 
		return null;

}
}