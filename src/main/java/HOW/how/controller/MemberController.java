package HOW.how.controller;

import HOW.how.domain.Member;
import HOW.how.dto.LoginRequestDTO;
import HOW.how.dto.MemberFormDTO;
import HOW.how.dto.TokenDTO;
import HOW.how.dto.TokenRequestDTO;
import HOW.how.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    
    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@RequestBody MemberFormDTO memberFormDTO){
        return ResponseEntity.ok(memberService.signup(memberFormDTO));
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(memberService.login(loginRequestDTO));
    }

    //토큰 재발급
    @PostMapping("/reissue")
    public ResponseEntity<TokenDTO> reissue(@RequestBody TokenRequestDTO tokenRequestDTO){
        return ResponseEntity.ok(memberService.reissue(tokenRequestDTO));
    }


    //회원 정보 수정
    @PutMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestBody MemberFormDTO memberFormDTO){
        Member member = memberService.updateMember(memberFormDTO);

        if(member ==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(member);
    }


}
