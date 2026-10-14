package com.pgcrp.publicgrievancecomplaintredressalportal.sampledata;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.*;
import com.pgcrp.publicgrievancecomplaintredressalportal.repository.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CsvDataLoader {

    public static void loadComplaints(ComplaintRepository repository) {

        try (BufferedReader reader = getReader("data/complaints.csv")) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 10) {
                    throw new IllegalArgumentException(
                            "Invalid complaint CSV row: " + line
                    );
                }

                Complaint complaint = new Complaint(
                        data[0].trim(),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        data[4].trim(),
                        data[5].trim(),
                        data[6].trim(),
                        data[7].trim(),
                        Boolean.parseBoolean(data[8].trim()),
                        Integer.parseInt(data[9].trim())
                );

                repository.saveComplaint(
                        complaint.getComplaintId(),
                        complaint
                );
            }

            System.out.println("Complaints loaded successfully.");

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load complaints.csv", e
            );
        }
    }

    public static void loadCitizens(CitizenRepository repository) {

        try (BufferedReader reader = getReader("data/citizens.csv")) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    throw new IllegalArgumentException(
                            "Invalid citizen CSV row: " + line
                    );
                }

                Citizen citizen = new Citizen(
                        data[0].trim(),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        data[4].trim()
                );

                repository.save(citizen);
            }

            System.out.println("Citizens loaded successfully.");

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load citizens.csv", e
            );
        }
    }

    public static void loadFieldWorkers(FieldWorkerRepository repository) {

        try (BufferedReader reader = getReader("data/fieldworkers.csv")) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    throw new IllegalArgumentException(
                            "Invalid field worker CSV row: " + line
                    );
                }

                FieldWorker worker = new FieldWorker(
                        data[0].trim(),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        Boolean.parseBoolean(data[4].trim())
                );

                repository.save(worker);
            }

            System.out.println("Field workers loaded successfully.");

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load fieldworkers.csv", e
            );
        }
    }

    private static BufferedReader getReader(String fileName) {

        InputStream inputStream =
                CsvDataLoader.class.getClassLoader()
                        .getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException(
                    "CSV file not found: " + fileName
            );
        }

        return new BufferedReader(
                new InputStreamReader(
                        inputStream,
                        StandardCharsets.UTF_8
                )
        );
    }
}