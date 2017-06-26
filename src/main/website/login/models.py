from django.db import models

# Create your models here.
class MyUser(models.Model):
    userid = models.IntegerField(db_column='UserID', blank=True, null=True)  # Field name made lowercase.
    username = models.CharField(db_column='UserName', max_length=1000, blank=True, null=True)  # Field name made lowercase.
