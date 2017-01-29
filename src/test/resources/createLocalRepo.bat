
SET testdir=%1
SET svndir=%testdir:\=/%

:: Create repo
svnadmin create --fs-type fsfs %svndir%/testrepo

echo create a local directory to checkout the repo
mkdir %testdir%\local
cd %testdir%\local

:: checkout
svn checkout file:///%svndir%/testrepo

echo go to checked out folder
cd %testdir%\local\testrepo

echo create empty file test1.txt and add to vcs
type NUL > test1.txt
svn add test1.txt
svn commit -m "Test message 1"

echo create empty file test2.txt and add to vcs
type NUL > test2.txt
svn add test2.txt
svn commit -m "Test message 2"

