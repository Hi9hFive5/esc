package org.highfives.esc.User.service;

import jakarta.transaction.Transactional;
import org.highfives.esc.User.dto.StudyclubMemberDTO;

public interface StudyclubMemberService {


    StudyclubMemberDTO insetMemberById(String id, String studyclubId);


    void deleteByMemberIdAndStudyclubId(String memberId, String studyclubId);
}
