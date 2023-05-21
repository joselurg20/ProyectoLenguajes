const gulp = require('gulp');
const {exec} = require('child_process');

gulp.task('run', function(cb) {
    exec('.\\mvnw clean spring-boot:run', function(err, stdout, stderr) {
        console.log(stdout);
        console.error(stderr);
        cb(err);
    });
});


gulp.task('default', gulp.parallel('run'));
