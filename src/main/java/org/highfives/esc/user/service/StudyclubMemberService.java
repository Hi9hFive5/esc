package org.highfives.esc.user.service;

import org.highfives.esc.user.dto.StudyclubMemberDTO;

public interface StudyclubMemberService {


    StudyclubMemberDTO insetMemberById(String id, String studyclubId);


    void deleteByMemberIdAndStudyclubId(String memberId, String studyclubId);

}
