package com.example.home.Bean

data class postInfobean(val log_id :Long,val results:ArrayList<postInfo>)
data class postInfo(val name:String,val score :Float)