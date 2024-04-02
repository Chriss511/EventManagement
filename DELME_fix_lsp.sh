#!/bin/bash


echo "
(1) fix lsp
(2) go to original state
"
read input

case $input in
    1)
        mv .project ../
        echo ".project moved to parent directory."
        ;;
    2)
        mv ../.project ./
        echo ".project moved from parent directory."
        ;;
    *)
        echo "Invalid input. Please enter either 1 or 2."
        ;;
esac

