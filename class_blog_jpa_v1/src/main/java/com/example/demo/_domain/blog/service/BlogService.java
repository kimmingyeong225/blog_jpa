package com.example.demo._domain.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo._domain.blog.dto.ArticleDTO;
import com.example.demo._domain.blog.entity.Article;
import com.example.demo._domain.blog.rapository.PostRepository;
import com.example.demo.common.errors.Exception400;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // IoC (빈으로 등록)
public class BlogService {
	
	//@Autowired // DI <-- 개발자들이 가독성 때문에 작성을 해준다.
	private final PostRepository postRepository;
	
	@Transactional // (작업의 단위) // 쓰기 지연 처리까지
	public Article save(ArticleDTO dto) {
		// 비즈니스 로직이 필요하다면 작성...
		return postRepository.save(dto.toEntity());
	}
	
	// 전체 게시글 조회 기능
	public List<Article> findAll(){
		List<Article> articles = postRepository.findAll();
		
		return articles;
	}
	
	// 상세 보기 게시글 조회
	public Article findById(Integer id) {
		// Optional<T>는 Java 8에서 도입된 클래스이며,
		// 값이 존재할 수도 있고 없을 수도 있는 상황을 명확하게 처리하기 위해 사용됩니다.
      return postRepository.findById(id).orElseThrow(() -> new Exception400("해당 게시글이 없습니다."));
	}
	
	@Transactional
	public Article update(Integer id, ArticleDTO dto) {
		
		// 수정 로직
		Article articleEntity = postRepository
				.findById(id).orElseThrow( () -> new Exception400("not found : " + id));
		
		// 객체 상태 값 변경
		articleEntity.update(dto.getTitle(), dto.getContent());
		// 영속성 컨테스트 -
		// DB 에 save 처리
		//postRepository.save(articleEntity);
		
		return articleEntity;
		
	}

	
	
}
