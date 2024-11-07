<div align="center">
    <h3>Spring Boot + AWS S3 Integration for Employee Management</h3>
<p align="center">
    <img src="https://miro.medium.com/v2/resize:fit:1280/0*lrhD8e1zlemTCUvT.png" alt="Spring Boot Logo" width="200"/>
    <img src="https://www.google.com/search?sca_esv=6fa4053b1bfce2fa&rlz=1C1GCEA_enTR1093TR1093&sxsrf=ADLYWIJvOaPtXrA7f_PfxEQVnrXbc1WaAQ:1731008682343&q=spring+boot+png+logo&udm=2&fbs=AEQNm0CgMcZ11KbHg1uunEmuo39LYaLxf_n_v5Qu9vkTINnKPNxSSRV--bGiJa6CXOAP_ugPFhSqVl_67Ejso-Ggkj9PxpCPkGM5OdNmxhREkjStggQbcgI9d0E71zBeVfytCHdPUCGOP5kAdZAI9qK9DsXTgNLuSC5QDJ39OD_e4jLFy07Ghgky4BnmGDywGvRAWqGDk2Ax&sa=X&ved=2ahUKEwj0wfTs_cqJAxWuQvEDHc0ZGP8QtKgLegQIFxAB&biw=1707&bih=772&dpr=1.13#vhid=h1GXkw2I0ZPN2M&vssid=mosaic" alt="AWS S3 Logo" width="200"/>
</p>
    <p>A project that integrates Spring Boot, PostgreSQL, and AWS S3 to manage employee data and images with CRUD operations displayed on a web interface.</p>
    <br/>
    <a href="https://github.com/FatihArslan-cmd/AWS-S3-SPRINGBOOT-INTEGRATION"><strong>🌟 Explore the docs »</strong></a>
    <br/><br/>
    <a href="https://github.com/FatihArslan-cmd/AWS-S3-SPRINGBOOT-INTEGRATION/issues/1">🐛 Report Bug</a> . 
    <a href="https://github.com/FatihArslan-cmd/AWS-S3-SPRINGBOOT-INTEGRATION/issues/1">✨ Request Feature</a>
</div>

<h2>📖 Table of Contents</h2>
<ol>
    <li><a href="#about-the-project">📘 About The Project</a></li>
    <li><a href="#getting-started">🚀 Getting Started</a>
        <ul>
            <li><a href="#prerequisites">📋 Prerequisites</a></li>
            <li><a href="#installation">⚙️ Installation</a></li>
            <li><a href="#usage">🛠️ Usage</a></li>
        </ul>
    </li>
    <li><a href="#dependencies">📦 Dependencies</a></li>
    <li><a href="#screenshots">Screenshots</a></li>
    <li><a href="#contributing">🤝 Contributing</a></li>
    <li><a href="#contact">📞 Contact</a></li>
</ol>

<h2 id="about-the-project">📘 About The Project</h2>
<p>Key Features:</p>
<ul>
    <li>🗄️ <strong>PostgreSQL Database Integration:</strong> Employee and department data are stored in PostgreSQL, with data imported from CSV files for easy initialization.</li>
    <li>🖼️ <strong>AWS S3 Image Storage:</strong> Employee images are stored in AWS S3 for secure and scalable image storage.</li>
    <li>🔄 <strong>CRUD Operations:</strong> Full CRUD functionality for employee data, displayed on a web page.</li>
    <li>📋 <strong>Web Interface:</strong> Displays employee details (name, manager name, salary, commission, department) with a JOIN operation, allowing for easy management and viewing.</li>
</ul>
<hr>

<h2 id="screenshots">Screenshots</h2>
<div align="center">
    <img src="https://github.com/user-attachments/assets/556bcac5-2072-44f1-9e41-ab862fa111db" width="900" alt="Screenshot"/>
    <img src="https://github.com/user-attachments/assets/2f5ae650-c94f-4f49-aefd-b2feb859d43a" width="900" alt="Screenshot"/>
</div>

<h2 id="getting-started">🚀 Getting Started</h2>
<p>To get a local copy up and running, follow these steps.</p>

<h3 id="prerequisites">📋 Prerequisites</h3>
<p>Ensure you have the following software installed:</p>
<ul>
    <li>Java 17+</li>
    <li>Maven</li>
    <li>AWS CLI (for AWS S3 integration)</li>
    <li>PostgreSQL</li>
</ul>

<h3 id="installation">⚙️ Installation</h3>
<ol>
    <li>Clone the repository:
        <pre><code>git clone https://github.com/FatihArslan-cmd/AWS-S3-SPRINGBOOT-INTEGRATION.git</code></pre>
    </li>
    <li>Navigate to the project directory:
        <pre><code>cd EmployeeManagementSystem</code></pre>
    </li>
    <li>Install dependencies:
        <pre><code>mvn clean install</code></pre>
    </li>
    <li>Run the project:
        <pre><code>mvn spring-boot:run</code></pre>
    </li>
</ol>

<h4>Set up AWS S3 Bucket:</h4>
<ol>
    <li>Create an S3 bucket and upload sample images from this link <a href="https://github.com/ozmen54/SWE307-2023/tree/main/Pro1/images">images</a>.</li>
    <li>Configure your AWS credentials using <code>aws configure</code>.</li>
</ol>

<h4>Set up PostgreSQL:</h4>
<ol>
    <li>Import employee and department data from the provided CSV files into PostgreSQL from <a href="https://github.com/ozmen54/SWE307-2023/tree/main/Pro1/data">data</a>.</li>
</ol>
<hr>
<h2>🔑 Configuration</h2>
<p>Add the following keys to your <code>application.properties</code> file:</p>

<pre><code>
aws.accessKeyId=""
aws.secretAccessKey=""
aws.region=""
aws.bucketName=""

spring.datasource.url=""
spring.datasource.username=""
spring.datasource.password=""
</code></pre>

<h2 id="usage">🛠️ Usage</h2>
<p>Once the project is running:</p>
<ul>
    <li>Open your browser and navigate to <a href="http://localhost:8080">http://localhost:8080</a> to view the employee data and perform CRUD operations.</li>
    <li>The employee table includes name, manager, salary, commission, and department, displayed with a JOIN operation.</li>
    <li>You can upload employee images, which will be stored in S3 and displayed on the page.</li>
</ul>
<hr>

<h2 id="dependencies">📦 Dependencies</h2>
<ul>
    <li>Java 17+</li>
    <li>Spring Boot</li>
    <li>PostgreSQL</li>
    <li>AWS SDK for Java (for S3 integration)</li>
    <li>Maven (for build management)</li>
</ul>
<hr>

<h2 id="contributing">🤝 Contributing</h2>
<p>Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.</p>
<ol>
    <li>Fork the Project</li>
    <li>Create your Feature Branch (<code>git checkout -b feature/AmazingFeature</code>)</li>
    <li>Commit your Changes (<code>git commit -m 'Add some AmazingFeature'</code>)</li>
    <li>Push to the Branch (<code>git push origin feature/AmazingFeature</code>)</li>
    <li>Open a Pull Request</li>
</ol>
<hr>

<h2 id="contact">📞 Contact</h2>
<p>Fatih Arslan - Software Developer</p>
