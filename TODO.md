# FrameBlog Refactoring - Fix Broken Project

## Current Status
- [x] Ran `mvn clean compile` - identified 3 compilation errors
- [x] Analyzed Post.java, PostServiceImpl.java, PostRepository.java, Tag.java
- Build fails due to model/repo/service inconsistencies

## Fix Plan (Compilation Errors First)

### 1. Fix PostRepository.java [Pending]
```
src/main/java/com/blog/FrameBlog/repositories/PostRepository.java
```
- Convert manual class → `@Repository interface extends JpaRepository<Post, Long>`
- Remove manual methods (auto-provided by Spring Data JPA)
- Fixes: Service cast errors (Optional<Object> → Optional<Post>)

### 2. Fix Post.java Model [Pending]
```
src/main/java/com/blog/FrameBlog/models/Post.java
```
- Remove duplicate empty `getTagId()` methods (lines 72-76)
- Add `@ManyToOne private Tag tag;`
- Add `getTag()/setTag(Tag tag)`
- Add constructor `Post(Long postId, String title, String content, Date date, User userId, Tag tag)`
- Optional: `getTagId() { return tag != null ? tag.getTagId() : null; }`

### 3. Fix PostServiceImpl.java [Pending]
```
src/main/java/com/blog/FrameBlog/services/impl/PostServiceImpl.java
```
- Remove all `(Post)` casts (lines 24,40,47,48)
- Line 30: `Tag tag = tagRepository.findById(post.getTagId()).orElse(null); new Post(..., tag)`

### 4. Verify & Next Steps [Pending]
```
- Run .\mvnw.cmd clean compile
- If passes: .\mvnw.cmd test
- Fix remaining compilation errors iteratively
- Refactor other services (V2/UserServiceV2Impl, CommentServiceImpl, etc.)
- Runtime testing
- Code quality improvements
```

## Next Action
Proceed with step-by-step fixes starting with PostRepository.java?

**Run `.\mvnw.cmd clean compile` anytime to check progress.**