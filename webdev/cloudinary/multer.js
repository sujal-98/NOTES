// Multer is a middleware for handling multipart/form-data, which is primarily used for uploading files in Node.js applications. It's particularly useful when working with forms where users need to upload files, such as images, documents, or any other type of file. Multer makes it easier to process and manage file uploads, providing both memory and disk storage options.

// Key Features of Multer
// Handling multipart/form-data: Multer processes the multipart/form-data format, which is the standard encoding for file uploads in HTML forms.
// File Storage: Multer allows you to specify where to store the uploaded files — either on the disk or in memory (as a buffer).
// File Size Limits: Multer lets you define file size limits and reject uploads that exceed the specified size.
// File Filtering: You can filter files based on their type (e.g., only allowing images).
// Multiple File Uploads: Multer supports uploading multiple files at once and accessing individual files in the request.


// Usage-


// const express = require('express');
// const multer = require('multer');
// const app = express();

// // Configure disk storage
// const storage = multer.diskStorage({
//   destination: (req, file, cb) => {
//     cb(null, 'uploads/');  // Destination folder for the files
//   },
//   filename: (req, file, cb) => {
//     cb(null, Date.now() + '-' + file.originalname);  // Rename the file to avoid conflicts
//   }
// });

// // Initialize Multer with the storage configuration
// const upload = multer({ storage: storage });

// // Endpoint for uploading a single file
// app.post('/upload', upload.single('file'), (req, res) => {
//   res.send('File uploaded successfully!');
// });

// // Start the server
// app.listen(3000, () => {
//   console.log('Server is running on port 3000');
// });



// Multer Storage Options
// Multer provides two main ways to store files:

// Disk Storage: Stores the file physically on the server’s file system.
// Memory Storage: Stores the file in memory as a buffer (useful for cases where you don't want to save the file directly, but instead want to process it first, e.g., uploading to cloud storage services like Cloudinary).

// Common Use Cases of Multer
// Uploading files to a local file system: Handling user file uploads such as profile images, documents, etc.
// Processing files before saving: Using memory storage when you need to process files (e.g., compress images) before saving them or uploading to cloud storage (e.g., Amazon S3, Cloudinary).
// File validation: Validating files based on type and size before uploading to ensure the correct format and size are uploaded.