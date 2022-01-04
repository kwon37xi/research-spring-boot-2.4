package kr.pe.kwonnam.researchspringboot.sse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import javax.servlet.http.HttpServletResponse;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link org.springframework.web.servlet.mvc.method.annotation.SseEmitter} 테스트
 *
 * @see <a href="https://www.baeldung.com/spring-server-sent-events">Server-Sent Events in Spring</a>
 */
@RestController
@RequestMapping("/stream-sse-emitter")
public class SseEmitterController {
    @GetMapping("/text-stream")
    public SseEmitter textStream(HttpServletResponse response) {
        // Timeout 을 지정하지 않으면, server(tomcat) 의 기본 timeout
        SseEmitter emitter = new SseEmitter(60000L);
        ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();

        // nginx에 버퍼링 금지 요청
        response.addHeader("X-Accel-Buffering", "no");

        sseMvcExecutor.execute(() -> {
            try {
                for (int i = 0; true; i++) {
                    SseEventBuilder event = SseEmitter.event()
                        .data("SSE MVC - " + LocalTime.now().toString())
                        .id(String.valueOf(i))
                        .name("sse event - mvc");
                    emitter.send(event);
                    Thread.sleep(1000L);
                }
            } catch (Exception ex) {
                emitter.completeWithError(ex);
                Thread.currentThread().interrupt();
            }
        });

        return emitter;
    }
}
