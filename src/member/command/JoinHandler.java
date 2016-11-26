package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {                             //commandHandler �������̽��� �����Ѵ�.

	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";  
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {   //��û ����� get�̸� processForm()�� �����ϰ�, ��û����� post�̸� processsubmit()�� �����Ѵ�. get���� post�� �ƴϸ� 405�����ڵ带 �����Ѵ�. 
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) { //processForm()�� ���� �����ִ� �� ��θ� �����Ѵ�.
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {  //processSubmit()�� �� ������ ó���Ѵ�.
		JoinRequest joinReq = new JoinRequest();      //���� �Է��� �����͸� �̿��ؼ� JoinRequest��ü�� �����Ѵ�.
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		joinReq.setPhone(req.getParameter("phone"));
		joinReq.setAddress(req.getParameter("address"));
		joinReq.setEmail(req.getParameter("email"));
		joinReq.setMoney(req.getParameter("money"));
		
		Map<String, Boolean> errors = new HashMap<>();      //���� ������ ���� �� ��ü�� �����ϰ�, errors�Ӽ��� �����Ѵ�.
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);         //joinRequest��ü�� ���� �ùٸ��� �˻��Ѵ�. ���� �ùٸ��� ���� ��� errors �� ��ü�� Ű�� �߰��Ѵ�.(JoinRequest�� validate()�޼��� �ڵ带 ����
		
		if (!errors.isEmpty()) {           //errors �� ��ü�� �����Ͱ� �����ϸ� �� �� ��θ� �����Ѵ�. errors�� �����Ͱ� �����Ѵٴ� ���� joinReq��ü�� �����Ͱ� �ùٸ��� �ʾ� 45�࿡�� errors�� ������ ���õ� Ű�� �߰��ߴٴ� ���� �ǹ��Ѵ�
			return FORM_VIEW;         //joinReq�� ���� �Է��� �����͸� �����ϰ� �����Ƿ� ���� �Է��� �����Ͱ� �ùٸ��� ������ �ٽ� ���� �����ְ� �ȴ�.
		}
		
		try {
			joinService.join(joinReq);   //JoinService�� join()�޽��带 �����Ѵ�. ����ó���� �����ϸ� 53�࿡�� ���� ����� ������ �� ��θ� �����Ѵ�.
			return "/index.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
