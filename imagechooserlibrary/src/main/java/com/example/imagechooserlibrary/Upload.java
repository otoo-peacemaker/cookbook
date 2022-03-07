/*
package com.example.imagechooserlibrary;

import android.net.Uri;
import android.os.FileUtils;
import android.util.Log;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Upload {

    private void uploadFile(Uri fileUri) {
    // create upload service client
    FileUploadService service =
            ServiceGenerator.createService(FileUploadService.class);

    // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
    // use the FileUtils to get the actual file by uri
    File file = FileUtils.getFile(this, fileUri);

    // create RequestBody instance from file
    RequestBody requestFile =
            RequestBody.create(
                         MediaType.parse(getContentResolver().getType(fileUri)),
                         file
             );

    // MultipartBody.Part is used to send also the actual file name
    MultipartBody.Part body =
            MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

    // add another part within the multipart request
    String descriptionString = "hello, this is description speaking";
    RequestBody description =
            RequestBody.create(
                    okhttp3.MultipartBody.FORM, descriptionString);

    // finally, execute the request
    Call<ResponseBody> call = service.upload(description, body);
    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call,
                               Response<ResponseBody> response) {
            Log.v("Upload", "success");
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            Log.e("Upload error:", t.getMessage());
        }
    });
}

}
*/
