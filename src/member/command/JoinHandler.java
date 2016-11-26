package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {                             //commandHandler 인터페이스를 구현한다.

	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";  
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {   //요청 방식이 get이면 processForm()을 실행하고, 요청방식이 post이면 processsubmit()을 실행한다. get도는 post가 아니면 405응답코드를 전송한다. 
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) { //processForm()은 폼을 보여주는 뷰 경로를 리턴한다.
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {  //processSubmit()은 폼 전송을 처리한다.
		JoinRequest joinReq = new JoinRequest();      //폼에 입력한 데이터를 이용해서 JoinRequest객체를 생성한다.
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		joinReq.setPhone(req.getParameter("phone"));
		joinReq.setAddress(req.getParameter("address"));
		joinReq.setEmail(req.getParameter("email"));
		joinReq.setMoney(req.getParameter("money"));
		
		Map<String, Boolean> errors = new HashMap<>();      //에러 정보를 담을 맵 객체를 생성하고, errors속성에 저장한다.
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);         //joinRequest객체의 값이 올바른지 검사한다. 값이 올바르지 않을 경우 errors 맵 객체에 키를 추가한다.(JoinRequest의 validate()메서드 코드를 보자
		
		if (!errors.isEmpty()) {           //errors 맵 객체에 데이터가 존재하면 폼 뷰 경로를 리턴한다. errors에 데이터가 존재한다는 것은 joinReq객체의 데이터가 올바르지 않아 45행에서 errors에 에러와 관련된 키를 추가했다는 것을 의미한다
			return FORM_VIEW;         //joinReq는 폼에 입력한 데이터를 저장하고 있으므로 폼이 입력한 데이터가 올바르지 않으면 다시 폼을 보여주게 된다.
		}
		
		try {
			joinService.join(joinReq);   //JoinService의 join()메스드를 실행한다. 가입처리에 성공하면 53행에서 성공 결과를 보여줄 뷰 경로를 리턴한다.
			return "/index.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
