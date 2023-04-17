package team.study.data.model

enum class NaverError(val code: Int, val msg: String) {
    BAD_REQUEST(400, "요청 변수 확인"),
    UNAUTHORIZED(401, "인증 실패"),
    FORBIDDEN(403, "서버가 허용하지 않는 호출"),
    NOT_FOUND(404, "API 없음"),
    METHOD_NOT_ALLOWED(405, "메서드 허용 안 함"),
    MANY_REQUEST(429, "호출 한도 초과 오류"),
    INTERNAL_SERVER_ERROR(405, "서버 오류"),
}
