# Contacts CLI (CS489 quiz)

## Quiz question — Question 1 (40 points)

### Problem statement

For this quiz, you will perform requirements, analysis, domain modeling and implement a basic Java **Command-Line Interface (CLI)** application to keep track of **Contacts**. Each Contact has a first name, last name, company, job title, zero or more **Phone Numbers**, and zero or more **Email Addresses**. Each Email Address has an actual address field and a label so that users can write something to indicate how it is related to the Contact (like home, mobile, work, etc.). Similarly, each Phone Number also has a field for the number and a field for a label.

The user of the application should be able to **search** through the contacts, **add** new contacts, **update** existing contacts, and **delete** old contacts. In addition to this, it is important to be able to **merge duplicate contacts**.

### Sample Contacts data

<table border="1" style="border-collapse: collapse; width: 100%;">
  <thead>
    <tr>
      <th style="padding: 6px;">First Name</th>
      <th style="padding: 6px;">Last Name</th>
      <th style="padding: 6px;">Company</th>
      <th style="padding: 6px;">Job Title</th>
      <th colspan="2" style="padding: 6px;">Phone Numbers</th>
      <th colspan="2" style="padding: 6px;">Email Addresses</th>
    </tr>
    <tr style="background-color: #d9d9d9;">
      <th colspan="4" style="padding: 6px;"></th>
      <th style="padding: 6px;">Phone No</th>
      <th style="padding: 6px;">Label</th>
      <th style="padding: 6px;">Email</th>
      <th style="padding: 6px;">Label</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="2" style="padding: 6px; vertical-align: top;">David</td>
      <td rowspan="2" style="padding: 6px; vertical-align: top;">Sanger</td>
      <td rowspan="2" style="padding: 6px; vertical-align: top;">Argos LLC</td>
      <td rowspan="2" style="padding: 6px; vertical-align: top;">Sales Manager</td>
      <td style="padding: 6px;">240-133-0011</td>
      <td style="padding: 6px;">Home</td>
      <td style="padding: 6px;">dave.sang@gmail.com</td>
      <td style="padding: 6px;">Home</td>
    </tr>
    <tr>
      <td style="padding: 6px;">240-112-0123</td>
      <td style="padding: 6px;">Mobile</td>
      <td style="padding: 6px;">dsanger@argos.com</td>
      <td style="padding: 6px;">Work</td>
    </tr>
    <tr>
      <td style="padding: 6px;">Carlos</td>
      <td style="padding: 6px;">Jimenez</td>
      <td style="padding: 6px;">Zappos</td>
      <td style="padding: 6px;">Director</td>
      <td style="padding: 6px;"></td>
      <td style="padding: 6px;"></td>
      <td style="padding: 6px;"></td>
      <td style="padding: 6px;"></td>
    </tr>
    <tr>
      <td style="padding: 6px;">Ali</td>
      <td style="padding: 6px;">Gafar</td>
      <td style="padding: 6px;">BMI Services</td>
      <td style="padding: 6px;">HR Manager</td>
      <td style="padding: 6px;">412-116-9988</td>
      <td style="padding: 6px;">Work</td>
      <td style="padding: 6px;">ali@bmi.com</td>
      <td style="padding: 6px;">Work</td>
    </tr>
  </tbody>
</table>

---

#### Phase 1 — Analysis and design

**Task 1.1 — Functional requirements**

- Discover the **functional requirements** and write them as a list of short statements in a **`.txt`** file.

**Task 1.2 — UML class diagram**

- Draw classes from the problem statement (**JPEG** or **PNG**).
- If you use paper, put your **name** and **Student ID** on it before submitting; tools such as **StarUML** are fine.

---

#### Phase 2 — Repository and implementation

**Task 2.1 — Directory and Git**

- Use one folder for the project; add the **1.1** text file and **1.2** image. **Initialize Git yourself** when you are ready (e.g. `git init`).
- Save a **terminal screenshot** (proof of initialization) in **`screenshots/`**.

**Task 2.2 — Java CLI project**

- Create a **Maven** or **Gradle** **Java CLI** project inside the repo.
- Screenshot the project in your **IDE** with **every folder expanded**.

**Task 2.3 — `model` package**

- Add a Java package named **`model`** and implement the **classes from your UML diagram** there.

**Task 2.4 — JSON CLI**

- Build an **array of contacts** from the quiz **Sample Contacts** table.
- Print **JSON** to the console, contacts **sorted by last name** (ascending).
- Save an **output screenshot** (PNG/JPG) under **`screenshots/`**.

**Task 2.5 — GitHub**

- Create a **GitHub** repository and push your project.
- Push **`screenshots/`**; do **not** push Maven **`target/`** or Gradle **`build/`** (use `.gitignore`).

---

> **Submission (Question 1)**  
> Zip the **folder that contains your `.git` directory** (everything for Tasks **1.1** through **2.4**). Upload **`.zip`**, **`.rar`**, or **`.7z`** to Sakai — **max 20 MB**.

---

## Quiz question — Question 2 (2 points)

Enter (or copy and paste) the **URL of your GitHub repository** created in Question 1.

---

## Manual commands — run and submit

Use the commands below to build, run, and submit your work.

### Prerequisites

- **JDK 17** (or newer)
- **Maven 3.x**

Replace the path below if your project lives elsewhere.

```bash
cd "/Users/mac/MIU/12. Applied Software Development/CS489/quiz/contacts-cli"
```

---

### Task 2.1 — Directory, Git init, and screenshot

Place your **Task 1.1** `.txt` and **Task 1.2** diagram image in this project folder, then initialize Git (example):

```bash
git init
git branch -M main
git status
```

Take a **terminal screenshot** showing the repository initialized (for example `git status` listing the branch and working tree) and save it under **`screenshots/`** (for example `screenshots/2.1 task.png`).

---

### Task 2.2 — Maven project and IDE screenshot

Create or refresh the project (already present here):

```bash
mvn -q validate
```

Open this folder in your IDE as a **Maven** project. Expand all source folders, then take a screenshot and save it as `screenshots/ide-project.png` (or `.jpg`).

---

### Task 2.3 / 2.4 — Build and run (JSON output)

Compile and run the CLI (prints contacts as JSON, sorted by last name):

```bash
mvn -q compile exec:java
```

Alternative (compile then run with classpath — useful if you prefer `java` directly):

```bash
mvn -q compile dependency:build-classpath -Dmdep.outputFile=cp.txt
java -cp "target/classes:$(cat cp.txt)" com.contacts.cli.ContactsCliApp
rm -f cp.txt
```

Take a screenshot of the **console output** in your IDE or terminal and save it under `screenshots/` (for example `screenshots/cli-json-output.png`).

---

### Task 2.5 — GitHub

Create a **GitHub** repository and push using your own Git workflow. Do **not** commit Maven **`target/`** or Gradle **`build/`** (see `.gitignore`).

---

### Submission (Question 1)

From the **parent** of `contacts-cli`, create a zip of the whole project folder (including the `.git` directory and `screenshots/`):

```bash
cd "/Users/mac/MIU/12. Applied Software Development/CS489/quiz"
zip -r contacts-cli-submission.zip contacts-cli -x "contacts-cli/target/*"
```

Upload `contacts-cli-submission.zip` to Sakai (max 20MB). For **Question 2**, paste the same GitHub repository URL in Sakai (see the **Quiz question — Question 2** section at the top of this file).
