package com.itwillbs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/boards/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	// 서비스 객체 주입
	@Autowired
	private BoardService service;
	
	// http://localhost:8080/controller/boards/regist
	// http://localhost:8080/boards/regist
	
	// 글쓰기 - 글정보 입력
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGET() throws Exception{
		logger.info("registGET() - 글정보 입력 !");
		logger.info("연결된 view 페이지 이동");
		//       /boards/regist.jsp
	}
	// 글쓰기 - 글쓰기 처리
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO vo,RedirectAttributes rttr) throws Exception{
		logger.info("registPOST() - 글쓰기 처리 !");
		// 한글처리 - 필터
		// 전달 정보 저장(파라메터 자동수집)
		logger.info("글쓰기 정보 : "+vo);
		// 서비스 - DB에 정보 저장()
		service.writeBoard(vo);
		// 정보 저장
		// model.addAttribute("result","ok"); // 주소줄에 데이터 표시 O, F5 데이터 유지 
		rttr.addFlashAttribute("result","ok"); // 주소줄에 데이터 표시 X, F5 데이터 유지X
		// 페이지 이동
		return "redirect:/boards/listALL";
		// return "redirect:/boards/listALL?result=ok";
	}
	
	// http://localhost:8080/boards/listALL
	// 게시판 글 리스트
	@RequestMapping(value = "/listALL",method = RequestMethod.GET)
	public void listAllGET(@ModelAttribute("result") String result,Model model) throws Exception{
		logger.info("listAllGET() 실행 "); // 글쓰기->이동, 그냥이동
		logger.info("result : "+result);
		
		// 서비스 - 모든 글정보 가져오기
		List<BoardVO> boardList =  service.getBoardListAll();
		logger.info("글 개수 "+boardList.size());
		
		model.addAttribute("boardList",boardList);
		model.addAttribute(boardList);
		
		// 연결된 view 페이지에 데이터 출력
		// /boards/listALL.jsp 출력
	}
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno,Model model) throws Exception{
		logger.info("readGET() 실행 !");
		// 전달 정보 저장
		logger.info("전달정보 bno : "+bno);
		// logger.info("전달정보 bno : {}",bno);
		
		// 조회수 1증가(viewcnt)
		service.incrementViewCnt(bno);
		// 글번호에 해당하는 글 정보 가져오기
		BoardVO resultVO = service.getBoard(bno);
		logger.info(resultVO+"");
		// 글정보를 저장 -> view 페이지 전달
		model.addAttribute("resultVO",resultVO);
		// model.addAttribute(resultVO);
		// model.addAttribute(service.getBoard(bno));
	}
	
	// 글 수정하기 - 기존의 글정보 보여주기(+수정할 정보 입력)
	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno,Model model) throws Exception{
		// 전달정보 저장 (bno)
		logger.info("bno : "+bno);
		// 글번호에 해당하는 글정보를 가져오기
		service.getBoard(bno);
		// 연결된 view 페이지 출력 =>
		model.addAttribute("vo",service.getBoard(bno));
		// 페이지 이동  ./boards/modify.jsp
		
	}
	// 글 수정하기 - 수정된 정보를 글정보 수정
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo,RedirectAttributes rttr) throws Exception{
		// 한글 인코딩(필터 생략)
		// 전달된 정보 저장하기(bno,title,writer,content)
		int result = service.modifyBoard(vo);
		if(result == 1) { // 수정된 정보가 1개일때
			rttr.addFlashAttribute("result","modOK");
		}
		// 페이지 이동
		return "redirect:/boards/listALL";
	}
	// 글 삭제하기 
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno,RedirectAttributes rttr) throws Exception{
		int result = service.removeBoard(bno);
		if(result == 1) {
			rttr.addFlashAttribute("result","delOK");
		}
		
		return "redirect:/boards/listALL";
	}
	
	
	
	
	
	
	
	
}
