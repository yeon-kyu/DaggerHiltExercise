# DaggerHiltExercise

##### 다른 프로젝트에서 DaggerHilt를 적용할 때 참고할 수 있도록 Activity/ViewModel/Repository/Network 에서 DI를 적용

###### 참고자료 https://medium.com/swlh/inject-viewmodel-using-hilt-2c968f1e85fe

###### 추가로 검토해야할 점
- @HiltAndroidApp 의 클래스는 Manifest 파일의 <application> 에서 android:name에 추가해야함
- Project 단의 dependency에서 kotlin-gradle-plugin이 1.5.20에서 @AndroidEntryPoint 쪽에서 컴파일 에러가 발생
-> 1.5.10 이하로 낮추어 해결 가능 
  (관련링크 : https://github.com/google/dagger/issues/2684)

</br>

## 사용 라이브라리
### DI
- DaggerHilt

### AAC
- DataBinding
- LiveData
- ViewModel

### Async
- Coroutine

### Network
- retrofit2 & OkHttp3 & Gson
