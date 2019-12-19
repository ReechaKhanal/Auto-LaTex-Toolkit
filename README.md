#### University of New Orleans
#### Mentor: Dr. Minhaz Zibran
#### Project Start Date: 01/01/2017 
#### Project End Date: 05/01/2017


# Auto-LaTex-Toolkit:
This tool was developed to be used an enhancement to the popular LaTex software. Key points about this tool is written below
  
    * It provides automated conversion between abbreviated and elborated publication venues in .bib files
    
    * This toolkit is aimed to be used as an enhancement to the popular LaTex software.
    
# More on the tool:
# Background/ Introduction:

# Background on Latex:
LaTeX is a high-quality typesetting system, arranging types and processing the data. It is available as a
free software and is most often used for medium-tolarge technical or scientific documents but can also
be used for almost any form of publishing

# Background on .bib files:
A .bib file is used for typesetting citations in a research article or a grant proposal.
A .bib extension in a file is used to describe bibliographical references.

# Why this toolkit:
Often, due to space requirements in journals and publications authors need to switch been abbreviated and elaborated form of publication names.
Example: if there is a limited space, the author would choose to use the abbreviated form of the publication name and similarly if there is enough space, the author would use the elaborated form of the publication.

This process of switching from elaborated names to abbreviated names, and vice-versa is manual, as of now.

Our aim through this project is to automate this manual conversion of names in latex.

# Steps in which the software works:
  1. Take a .bib file as an user input
  2. Allow the user to choose if he/she wants an abbreviated to elaborated conversion or an elaborated to abbreviated conversion
  2. Parse through the input file and extract abbreviated/elaborated names from the selected file
  3. Find a map for the extracted name
  4. If no map found ask user to input the correct mapping, and add the user-entered mapping to the original map of abbreviated to elaborated names
  5. Replace the names with their maps as requested by the user and return a new file as an output.
