package com.dgswiphak.ida.common.file

import com.dgswiphak.ida.common.dto.FileRequest
import org.springframework.core.io.Resource

interface FileService {

    /**
     * 인자값으로 들어온 경로로 파일을 저장합니다
     * <p/>
     * @param path 저장할 파일 경로
     * */
    fun save(path: String, fileRequest: FileRequest): String

    fun read(path: String): Resource

    fun delete(path: String)

}