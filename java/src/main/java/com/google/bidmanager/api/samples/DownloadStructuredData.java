package com.google.bidmanager.api.samples;

import com.google.api.services.doubleclickbidmanager.DoubleClickBidManager;
import com.google.api.services.doubleclickbidmanager.model.DownloadRequest;
import com.google.api.services.doubleclickbidmanager.model.DownloadResponse;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.util.Arrays;

public class DownloadStructuredData {

    public static void main(String[] args) throws Exception {
        // Get an authenticated connection to the API.
        DoubleClickBidManager service = SecurityUtilities.getAPIService();

        DownloadRequest request = new DownloadRequest();

        request.setFileTypes(Arrays.asList("INSERTION_ORDER"));
        System.out.println(request.toPrettyString());
        DownloadResponse response = service.sdf().download(request).execute();
        File to = new File("sdf_items.csv");
        Files.write(response.getInsertionOrders(), to, Charsets.UTF_8);
        System.out.println("Download complete.");
    }
}
